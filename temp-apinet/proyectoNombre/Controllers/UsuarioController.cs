
using ...

namespace nombreProyecto.Controllers
{
	[Route("api/[controller]")]
	[ApiController]
	public class UsuarioController : ControllerBase
	{

		private readonly UsuarioService _usuarioService;

		public UsuarioController(UsuarioService usuarioService)
		{
			_usuarioService = usuarioService;
		}


		[HttpGet]
		public IEnumerable<Usuario> GetUsuarios()
		{
			return new List<Usuario>
			{
				new Usuario {Id=1, Nombre="Juan", Apellido="Perez"}
			};
		}



		[HttpGet("id")]
		[ProducesResponseType(StatusCode.Status200OK)]
		[ProducesResponseType(400)]
		[ProducesResponseType(404)]
		public IActionResult<Usuario> GetUsuario(int id)
		{

			// validaciones
			// return BadRequest();
			// return NotFound();
			// return Ok();

			return Ok(
				new Usuario {Id=1, Nombre="Juan", Apellido="Perez"}
			);
		}





		[HttpPost]
		[ProducesResponseType(StatusCode.Status200OK)]
		[ProducesResponseType(400)]
		public IActionResult<Usuario> PostUsuario([FromBody] UsuarioDto usuarioDto)
		{

			// validaciones
			// if usuarioDto is null then  return BadRequest();
			// return NotFound();
			// return Ok();

			// continuar 1.19.20
			// https://www.youtube.com/watch?v=OuiExAqVapk 
			// Web APIs (NET 7) La Guia Completa (Crear y Consumir API)
			// BaezStone Creators 

			List<Usuario> usuarioDto = 

			if()
			{

			}

			return Ok(
				new Usuario {Id=1, Nombre="Juan", Apellido="Perez"}
			);
		}





	} // UsuarioController 

} // namespace 
