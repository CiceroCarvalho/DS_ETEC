using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AppLojaBoa.Models
{
    public class Produto
    {
        public int prodID { get; set; }
        public string prodNome { get; set; }
        public decimal prodValor { get; set; }
        public ushort prodQtd { get; set; }
    }
}