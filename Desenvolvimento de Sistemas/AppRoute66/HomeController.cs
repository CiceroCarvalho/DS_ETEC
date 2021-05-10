using AppRoute66.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace AppRoute66.Controllers
{
    public class HomeController : Controller
    {
        private readonly IEnumerable<Noticia> AsNoticias;
        
        public HomeController() 
        {
            AsNoticias = new Noticia().TodasAsNoticias().OrderByDescending(x => x.Data);
        }

        public ActionResult Index() 
        {
            var UltimasNoticias = AsNoticias.Take(3);
            var AsCategorias = AsNoticias.Select(x => x.Categoria).Distinct().ToList();

            ViewBag.Categoria = AsCategorias;
            return View(UltimasNoticias);
        }

        public ActionResult MostrarNoticia(int NoticiaId) 
        {
            return View(AsNoticias.FirstOrDefault(x => x.NoticiaId == NoticiaId));
        }

        public ActionResult MostraCategoria(string Categoria) 
        {
            var CategoriaEspecifica = AsNoticias.Where(x => x.Categoria.ToLower() == Categoria.ToLower()).ToList();
            ViewBag.Categoria = Categoria;
            return View(CategoriaEspecifica);
        }

        public ActionResult Noticias() 
        {
            return View(AsNoticias);
        }

        public ActionResult Estilo()
        {
            return View();
        }
    }
}