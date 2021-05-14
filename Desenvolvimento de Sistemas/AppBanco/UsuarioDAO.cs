using AppBancoADO;
using AppBancoDominio;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AppBancoDAO
{
    public class UsuarioDAO
    {
        private Banco db = new Banco();
        public void Insert(Usuario usuario)
        {
            string strInsert = string.Format("insert into tbusuario (NomeUsu,Cargo,DataNasc) " +
                                "Value('{0}','{1}','{2}');",
                                usuario.NomeUsu, usuario.Cargo, usuario.DataNasc.ToString("yyyy-MM-dd"));
            db.ExecutaComando(strInsert);
        }

        public void Update(Usuario usuario) 
        {
            string strquery;
            strquery = "update tbUsuario set ";
            strquery += string.Format(" NomeUsu = '{0}', ", usuario.NomeUsu);
            strquery += string.Format(" Cargo = '{0}', ", usuario.Cargo);
            strquery += string.Format(" DataNasc = '{0}' ", usuario.DataNasc.ToString("yyyy-MM-dd"));
            strquery += string.Format(" where IdUsu = {0};", usuario.IdUsu);
            db.ExecutaComando(strquery);
        }

        public void Delete(Usuario usuario) 
        {
            string strquery;
            strquery = "delete from tbUsuario ";
            strquery += string.Format(" where IdUsu = {0};", usuario.IdUsu);

            db.ExecutaComando(strquery);
        }

        public Usuario SelectId(int Id)
        {
            string strString = string.Format("Select * from tbUSUARIO where IdUsu = {0}", Id);
            var retorno = db.RetornaComando(strString);

            Usuario usuario = new Usuario();
            retorno.Read();
            usuario.IdUsu = int.Parse(retorno["IdUsu"].ToString());
            usuario.NomeUsu = retorno["NomeUsu"].ToString();
            usuario.Cargo = retorno["Cargo"].ToString();
            usuario.DataNasc = DateTime.Parse(retorno["DataNasc"].ToString());

            retorno.Close();
            return (usuario);
        }

        public MySqlDataReader Select() 
        {
            string strquery = "select * from tbUsuario;";
            return db.RetornaComando(strquery);
        }

        public List<Usuario> ListaUsuarios() 
        {
            var usuarios = new List<Usuario>();
            var retorno = Select();

            while (retorno.Read()) 
            {
                var tempUsuario = new Usuario()
                {
                    IdUsu = int.Parse(retorno["IdUsu"].ToString()),
                    NomeUsu = retorno["NomeUsu"].ToString(),
                    Cargo = retorno["Cargo"].ToString(),
                    DataNasc = DateTime.Parse(retorno["DataNasc"].ToString())
                };
                usuarios.Add(tempUsuario);
            }
            retorno.Close();
            return usuarios;
        }

    }
}
