using CiceroApp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CiceroApp.Controllers
{
    public class ClienteController : Controller
    {
        // GET: Cliente
        public ActionResult Index()
        {
            Cliente cliente = new Cliente()
            {
                ClienteID = 1,
                ClienteNome = "Bela",
                Cpf = 12345678911,
                Rg = 12345678,
                DigRg = Convert.ToChar("0"),
                ClienteTel = 123456789
            };

            return View(cliente);
        }
    }
}