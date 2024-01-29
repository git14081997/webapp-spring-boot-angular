
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using LibraryPersonal.Entity;
using ProyectoWebApiPuntoNet.DBContext;


//  content-type: text/plain; charset=utf-8 


namespace ProyectoWebApiPuntoNet.Controllers
{
 [Route("api/[controller]")]
 [ApiController]
 public class PersonaController : ControllerBase
 {
  private readonly DbZeroContext _context;

  public PersonaController(DbZeroContext context)
  {
   _context = context;
  }

  // GET: api/Persona
  [HttpGet]
  public async Task<ActionResult<IEnumerable<Persona>>> GetTPersona()
  {
   return await _context.TPersona.ToListAsync();
  }

  // GET: api/Persona/5
  [HttpGet("{id}")]
  public async Task<ActionResult<Persona>> GetPersona(int id)
  {
   var persona = await _context.TPersona.FindAsync(id);

   if (persona == null)
   {
    return NotFound();
   }

   return persona;
  }

  // PUT: api/Persona/5
  // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
  [HttpPut("{id}")]
  public async Task<IActionResult> PutPersona(int id, Persona persona)
  {
   if (id != persona.Id)
   {
    return BadRequest();
   }

   _context.Entry(persona).State = EntityState.Modified;

   try
   {
    await _context.SaveChangesAsync();
   }
   catch (DbUpdateConcurrencyException)
   {
    if (!PersonaExists(id))
    {
     return NotFound();
    }
    else
    {
     throw;
    }
   }

   return NoContent();
  }

  // POST: api/Persona
  // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
  [HttpPost]
  public async Task<ActionResult<Persona>> PostPersona(Persona persona)
  {
   _context.TPersona.Add(persona);
   await _context.SaveChangesAsync();

   return CreatedAtAction("GetPersona", new { id = persona.Id }, persona);
  }

  // DELETE: api/Persona/5
  [HttpDelete("{id}")]
  public async Task<IActionResult> DeletePersona(int id)
  {
   var persona = await _context.TPersona.FindAsync(id);
   if (persona == null)
   {
    return NotFound();
   }

   _context.TPersona.Remove(persona);
   await _context.SaveChangesAsync();

   return NoContent();
  }

  private bool PersonaExists(int id)
  {
   return _context.TPersona.Any(e => e.Id == id);
  }



  private static PersonaDTO ItemToDTO(Persona todoItem) =>
   new PersonaDTO
   {
    Id = todoItem.Id,
    Nombre = todoItem.Nombre,
    Edad = todoItem.Edad,
    Altura = todoItem.Altura,
    FechaNacimiento = todoItem.FechaNacimiento
 };

 } // class 
} // namespace 
