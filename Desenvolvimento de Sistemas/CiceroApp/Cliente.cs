using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CiceroApp.Models
{
    public class Cliente
    {
        public int ClienteID { get; set; }
        public string ClienteNome { get; set; }
        public Int64 Cpf { get; set; }
        public int Rg { get; set; }
        public char DigRg { get; set; }
        public int ClienteTel { get; set; }
    }
}