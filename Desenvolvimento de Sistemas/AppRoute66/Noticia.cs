using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Web;

namespace AppRoute66.Models
{
    public class Noticia
    {
        public int NoticiaId { get; set; }
        public string Titulo { get; set; }
        public string Categoria { get; set; }
        public string Conteudo { get; set; }
        public DateTime Data { get; set; }

        public IEnumerable<Noticia> TodasAsNoticias()
        {
            var retorno = new Collection<Noticia>
            {
                new Noticia
                {
                    NoticiaId=1,
                    Categoria = "Esporte",
                    Titulo = "Palmeiras é campeão!",
                    Conteudo = "O time do palmeiras " +
                    "vence de 10 x 0 nesta quinta-feira",
                    Data = new DateTime(08/04/2021)
                },
                new Noticia
                {
                    NoticiaId=2,
                    Categoria = "Escola",
                    Titulo = "Lucas Quietinho",
                    Conteudo = "O Lucas não fala nada sobre o time," +
                    " porque o time dele é o melhor!",
                    Data = new DateTime(18/04/2021)
                },
                new Noticia
                {
                    NoticiaId=3,
                    Categoria = "Esporte",
                    Titulo = "Palmeiras não é campeão!",
                    Conteudo = "O palmeiras não tem mundial!",
                    Data = new DateTime(28/04/2021)
                },
                new Noticia
                {
                    NoticiaId=4,
                    Categoria = "Escola",
                    Titulo = "Melhores alunos",
                    Conteudo = "Os alunos do 2DS tarde são os " +
                    "melhores do BG",
                    Data = new DateTime(01/04/2021)
                }
            };

            return retorno;
        }
    }
}