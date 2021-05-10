using QuintaApp.Models;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace QuintaApp.Controllers
{
    public class UsuarioController : Controller
    {
        // GET: Usuario
        public ActionResult Index()
        {
            var usuario = new Usuario();
            return View(usuario);
        }

        [HttpPost]
        public ActionResult Index(Usuario usuario)
        {
            if (ModelState.IsValid) 
            {
                return View("Resultado", usuario);
            }
           
            return View(usuario);
        }

        public ActionResult Resultado(Usuario usuario)
        {
            return View(usuario);
        }
        public ActionResult ValidaLogin(string login)
        {
            var dbExemplo = new Collection<string>
            {
                "Marcos",
                "Karen",
                "Leonardo",
                "Eric"
            };

            return Json(dbExemplo.All(a => a.ToLower() != login.ToLower()), JsonRequestBehavior.AllowGet);
        }
    }
}