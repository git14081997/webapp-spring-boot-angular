
using LibraryPersonal.Dto;
using LibraryPersonal.Entity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using ProyectoWebApiPuntoNet.DBContext;

namespace ProyectoWebApiPuntoNet.Controllers
{

 //[Route("api/[controller]")]
 [Route("api/usuario")]
 [ApiController]
 public class UsuarioController : ControllerBase
 {

  private DbZeroContext _dBContext;


  public UsuarioController(DbZeroContext dBContext) : base()
  {
   _dBContext = dBContext;
  }


  [HttpGet]
  public async Task<ActionResult<IEnumerable<Usuario>>> GetUsuarios()
  {
   return await _dBContext.TUsuario.ToListAsync();
  }





  [HttpPost]
  [ProducesResponseType( StatusCodes.Status201Created ) ]
  [ProducesResponseType(StatusCodes.Status400BadRequest)]
  [ProducesResponseType(StatusCodes.Status500InternalServerError )]
  public async Task<ActionResult<Usuario>> PostPersona( [FromBody] UsuarioDto newUsuario)
  {

   if ( newUsuario == null )
   {
    return BadRequest(newUsuario);
   }

   if (newUsuario.Id != null)
   {
    return StatusCode( StatusCodes.Status500InternalServerError);
   }



   Usuario newUser = dtoToEntity(newUsuario);

   newUser.NombreCompleto = newUser.Nombre + newUser.NombreDos + newUser.Apellido + newUser.ApellidoDos;
   newUser.PendienteDePago = 0;

   _dBContext.TUsuario.Add(newUser);
   await _dBContext.SaveChangesAsync();

   return CreatedAtAction("GetUsuario", new { id = newUser.Id }, newUser);
  }




  private static UsuarioDto entityToDto(Usuario usuario) =>
 new UsuarioDto
 {
  Id = usuario.Id,
  Nombre = usuario.Nombre,
  NombreDos = usuario.NombreDos,
  Apellido = usuario.Apellido,
  ApellidoDos = usuario.ApellidoDos
 };


  private static Usuario dtoToEntity(UsuarioDto dto) =>
new Usuario
{
 Nombre = dto.Nombre,
 NombreDos = dto.NombreDos,
 Apellido = dto.Apellido,
 ApellidoDos = dto.ApellidoDos
};






 } // class 

} // namespace 
