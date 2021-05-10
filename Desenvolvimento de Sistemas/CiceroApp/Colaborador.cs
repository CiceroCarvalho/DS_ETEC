using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace CiceroApp.Models
{
    public class Colaborador
    {
        [Key]
        [Range(1,100)]
        [Display (Name = "Identificação")]
        public int ColabId { get; set; }

        [Required(ErrorMessage = "Campo obrigatório")]
        [Display (Name = "Colaborador")]
        public string NomeColab { get; set; }

        [Required(ErrorMessage = "Campo obrigatório")]
        [Display (Name = "Função")]
        public string FuncaoColab { get; set; }

        [Required(ErrorMessage = "Campo obrigatório")]
        [Display (Name = "Data de Nascimento")]
        public DateTime NascColab { get; set; }

        [StringLength(50, MinimumLength = 5, ErrorMessage = "Mínimo de 5 caracter e máximo 50")]
        [Display (Name = "Observação")]
        public string ObsColab { get; set; }

        [Required]
        [EmailAddress(ErrorMessage = "O campo Email não é um endereço de email válido.")]
        [Display (Name = "Email")]
        public string EmailColab { get; set; }

        [Required(ErrorMessage = "Campo obrigatório")]
        [Display (Name = "Senha")]
        public string SenhaColab { get; set; }

        [Compare("SenhaColab", ErrorMessage = "As senhas são diferentes")]
        [Display (Name = "Confirme a senha")]
        public string ConfirmarsenhaColab { get; set; }

        [Required(ErrorMessage = "Campo obrigatório")]
        [Display (Name = "Login")]
        public string LoginColab { get; set; }
    }
}