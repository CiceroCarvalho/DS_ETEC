using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AppLojaBoa.Models
{
    public class Venda
    {
        public int vendaID { get; set; }
        public DateTime vendaData { get; set; }
        public decimal vendaTotal { get; set; }
    }
}