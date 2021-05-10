using CiceroApp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CiceroApp.Controllers
{
    public class ColaboradorController : Controller
    {
        // GET: Colaborador
        public ActionResult Index()
        {
            Colaborador colaborador = new Colaborador();
            return View(colaborador);
        }

        [HttpPost]
        public ActionResult Index(Colaborador colaborador) 
        {
            if (ModelState.IsValid) 
            {
                return View("Listar", colaborador);
            }
            return View(colaborador);
        }

        [HttpPost]
        public ActionResult Listar(Colaborador colaborador) 
        {
            return View(colaborador);
        }
    }
}