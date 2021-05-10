using QuintaApp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace QuintaApp.Controllers
{
    public class FuncionarioController : Controller
    {
        // GET: Funcionario
        public ActionResult Index()
        {
            Funcionario func = new Funcionario()
            {
                FuncID = 1,
                FuncNome = "Marcão",
                FuncFuncao = "CoronaVac"
            };

            return View(func);
            
        }

        [HttpPost]
        public ActionResult Listar(Funcionario func) 
        {
            return View(func);
        }
    }
}