using AppBancoDAO;
using AppBancoDominio;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleBanco
{
    class Program
    {
        static void Main(string[] args)
        {
            var usuario = new Usuario();
            var usuarioDAO = new UsuarioDAO();

            Console.ForegroundColor = ConsoleColor.Blue;

            Console.WriteLine("=======================-AppBanco-=======================");
            Console.WriteLine("-          0 - Cadastrar Usuário                       -");
            Console.WriteLine("-          1 - Editar Usuário                          -");
            Console.WriteLine("-          2 - Excluir Usuário                         -");
            Console.WriteLine("-          3 - Listar Usuários                         -");
            Console.WriteLine("-          4 - Sair                                    -");
            Console.WriteLine("========================================================");
            Console.WriteLine(" ");
            Console.Write("Qual opção você deseja: ");
            var OpcaoEscolhida = Console.ReadLine();

            if (OpcaoEscolhida == "") 
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("Pressione Enter e escolha uma das opções: 0, 1, 2, 3 ou 4");
                Console.ReadLine();
            }
            else 
            { 
                switch (OpcaoEscolhida) 
                {
                    case "0":
                        {
                            Console.Write("Digite o nome do usuário: ");
                            Console.ForegroundColor = ConsoleColor.Red;
                            usuario.NomeUsu = Console.ReadLine();

                            Console.ForegroundColor = ConsoleColor.Blue;
                            Console.Write("Digite o cargo do usuário: ");
                            Console.ForegroundColor = ConsoleColor.Red;
                            usuario.Cargo = Console.ReadLine();

                            Console.ForegroundColor = ConsoleColor.Blue;
                            Console.Write("Digite a data de nascimento do usuário: ");
                            Console.ForegroundColor = ConsoleColor.Red;
                            usuario.DataNasc = DateTime.Parse(Console.ReadLine());

                            Console.ForegroundColor = ConsoleColor.Blue;

                            usuarioDAO.Insert(usuario);

                            MySqlDataReader leitor = usuarioDAO.Select();
                            while (leitor.Read())
                            {
                                Console.WriteLine("ID: {0}, Nome: {1}, Cargo: {2}, Data: {3}",
                                leitor["IdUsu"], leitor["NomeUsu"], leitor["Cargo"], leitor["DataNasc"]);
                            }
                            Console.ReadLine();
                            break;
                        }  
                    case "1": 
                        {
                            Console.Write("Digite o nome do usuário: ");
                            Console.ForegroundColor = ConsoleColor.Red; 
                            usuario.NomeUsu = Console.ReadLine();

                            Console.ForegroundColor = ConsoleColor.Blue;
                            Console.Write("Digite o cargo do usuário: ");
                            Console.ForegroundColor = ConsoleColor.Red;
                            usuario.Cargo = Console.ReadLine();

                            Console.ForegroundColor = ConsoleColor.Blue;
                            Console.Write("Digite a data de nascimento do usuário: ");
                            Console.ForegroundColor = ConsoleColor.Red;
                            usuario.DataNasc = DateTime.Parse(Console.ReadLine());

                            Console.ForegroundColor = ConsoleColor.Blue;
                            Console.Write("Digite o código do usuário que deseja editar: ");
                            Console.ForegroundColor = ConsoleColor.Red;
                            usuario.IdUsu = Convert.ToInt32(Console.ReadLine());

                            Console.ForegroundColor = ConsoleColor.Blue;

                            usuarioDAO.Update(usuario);

                            MySqlDataReader leitor = usuarioDAO.Select();
                            while (leitor.Read())
                            {
                                Console.WriteLine("ID: {0}, Nome: {1}, Cargo: {2}, Data: {3}",
                                leitor["IdUsu"], leitor["NomeUsu"], leitor["Cargo"], leitor["DataNasc"]);
                            }
                            Console.ReadLine();
                            break;
                        }
                    case "2": 
                        {

                            Console.Write("Digite o código do usuário que deseja excluir: ");
                            Console.ForegroundColor = ConsoleColor.Red;
                            usuario.IdUsu = int.Parse(Console.ReadLine());

                            Console.ForegroundColor = ConsoleColor.Blue;

                            usuarioDAO.Delete(usuario);

                            MySqlDataReader leitor = usuarioDAO.Select();
                            while (leitor.Read())
                            {
                                Console.WriteLine("ID: {0}, Nome: {1}, Cargo: {2}, Data: {3}",
                                leitor["IdUsu"], leitor["NomeUsu"], leitor["Cargo"], leitor["DataNasc"]);
                            }
                            Console.ReadLine();
                            break;
                        }
                    case "3": 
                        {
                            MySqlDataReader leitor = usuarioDAO.Select();
                            while (leitor.Read())
                            {
                                Console.WriteLine("ID: {0}, Nome: {1}, Cargo: {2}, Data: {3}",
                                leitor["IdUsu"], leitor["NomeUsu"], leitor["Cargo"], leitor["DataNasc"]);
                            }
                            Console.ReadLine();
                            break;
                        }
                    case "4":
                        {
                            Environment.Exit(0);
                            break;
                        }
                    default: 
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.WriteLine("Digite apenas valores aceitáveis!");
                            Console.ReadLine();
                            break;
                        }
                }
            }
        }
    }
}
