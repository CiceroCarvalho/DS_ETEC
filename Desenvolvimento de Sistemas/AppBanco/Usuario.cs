using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AppBancoDominio
{
    public class Usuario
    {
        [Display(Name = "Código")]
        public int IdUsu { get; set; }

        [Display(Name = "Nome")]
        [Required(ErrorMessage = "Campo obrigatório")]
        public string NomeUsu { get; set; }

        [Display(Name = "Cargo")]
        [Required(ErrorMessage = "Campo obrigatório")]
        public string Cargo { get; set; }

        [Display(Name = "Data de Nascimento")]
        public DateTime DataNasc { get; set; }
    }
}
