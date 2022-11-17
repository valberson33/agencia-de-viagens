using Agencia_Web_API_FS.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Agencia_Web_API_FS.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DestinoController : ControllerBase
    {
        private readonly DestinoDbContext _context;

        public DestinoController(DestinoDbContext context)
        {
            _context = context;

        }
        [HttpGet]
        public IEnumerable<Destinos> GetDestinos()
        {
            return (IEnumerable<Destinos>)_context.destino;

        }
        [HttpGet("{id}")]

        public IActionResult GetDestinoPorId(int id)
        {
            Destinos destino = _context.destino.SingleOrDefault(m => m.ID == id);
            if (destino == null)
            {
                return NotFound();
            }
            return new ObjectResult(destino);
        }
        [HttpPost]
        public IActionResult CriarDestino([FromBody] Destinos item)
        {
            if (item == null)
            {
                return BadRequest();
            }
            _context.destino.Add(item);
            _context.SaveChanges();

            return new ObjectResult(item);
 
        }
    [HttpPut]
        public IActionResult AtualizarDestino(int id, [FromBody] Destinos item)
        {
            if(id != item.ID)
            {
                return BadRequest();
            }
            _context.Entry(item).State = EntityState.Modified;
            _context.SaveChanges();

            return new NoContentResult();
        }
        [HttpDelete("{id}")]
        public IActionResult DeletarDestino(int id) 
        {
            var destino = _context.destino.SingleOrDefault(m => m.ID == id);
            if (destino == null) 
            {
                return BadRequest();
            }

            _context.destino.Remove(destino);
            _context.SaveChanges();
            return Ok(destino);
        }
    }

}

