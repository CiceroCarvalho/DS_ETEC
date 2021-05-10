using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AppBancoADO
{
    public class Banco : IDisposable
    {
        private readonly MySqlConnection conexao;

        public Banco() 
        {
            conexao = new MySqlConnection(ConfigurationManager.ConnectionStrings["conexao"].ConnectionString);
            conexao.Open();
        }

        public void ExecutaComando(string strQuery) 
        {
            var vComando = new MySqlCommand
            {
                CommandText = strQuery,
                CommandType = CommandType.Text,
                Connection = conexao
            };

            vComando.ExecuteNonQuery();
        }

        public MySqlDataReader RetornaComando(string strQuery) 
        {
            var comando = new MySqlCommand(strQuery, conexao);
            
            return comando.ExecuteReader(); 
        }

        public void Dispose()
        {
            if(conexao.State == ConnectionState.Open) 
            {
                conexao.Close();
            }  
        }
    }
}
