using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace QuintaApp.Models
{
    public class Usuario
    {
        [Display(Name = "Código")]
        [Range(1, 2000, ErrorMessage = "O Id deve estar entre 1 e 2000")]
        public int UsuID { get; set; }

        [Required (ErrorMessage = "O nome é obrigatório!")]
        [Display(Name = "Nome do Usuário")]
        public string UsuNome { get; set; }
        
        [StringLength(50, MinimumLength = 5, ErrorMessage = "Insira uma informação de 5 até 50 caracteres.")]
        [Display (Name = "Observação")]
        public string UsuObs { get; set; }

        [Required]
        [Display (Name ="Data de Nascimento")]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}", ApplyFormatInEditMode = true)]
        public DateTime UsuNas { get; set; }

        [Required]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [RegularExpression(@"^[a-zA-Z]{5,15}", ErrorMessage = "Somente letras, no mínimo 5 e no máximo 15 caracteres")]
        [Remote("ValidaLogin","Usuario", ErrorMessage = "Usuário já existe!")]
        public string Login { get; set; }

        [Required(ErrorMessage = "Senha é obrigatória!")]
        public string Senha { get; set; }

        [System.ComponentModel.DataAnnotations.Compare("Senha", ErrorMessage = "Senha não confere!")]
        public string ConfirmarSenha { get; set; }
    }
}