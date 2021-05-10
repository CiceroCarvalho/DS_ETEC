using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AppLojaBoa.Models
{
    public class Cliente
    {
        public int cliID { get; set; }
        public string cliNome { get; set; }
        public string cliEnd { get; set; }
        public DateTime cliNasc { get; set; }
    }
}