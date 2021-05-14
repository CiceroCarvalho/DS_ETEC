using AppBancoDAO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using AppBancoDominio;
using AppBancoADO;

namespace AppWeb.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            var metodoUsuario = new UsuarioDAO();
            var todosUsuarios = metodoUsuario.ListaUsuarios();
            return View(todosUsuarios);
        }

        public ActionResult Lista()
        {
            var metodoUsuario = new UsuarioDAO();
            var todosUsuarios = metodoUsuario.ListaUsuarios();
            return View(todosUsuarios);
        }

        public ActionResult Create() 
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(Usuario usuario)
        {
            if (ModelState.IsValid) 
            {
                var metodoUsuario = new UsuarioDAO();
                metodoUsuario.Insert(usuario);

                return RedirectToAction("Lista");
            }
            return View();
        }

        public ActionResult ListaId(int Id)
        {
            var metodoUsuario = new UsuarioDAO();
            var usuario = metodoUsuario.SelectId(Id);
            return View(usuario);
        }
    }
}