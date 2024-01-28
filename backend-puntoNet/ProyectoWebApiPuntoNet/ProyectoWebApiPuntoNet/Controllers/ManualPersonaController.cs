/*
using Microsoft.AspNetCore.Mvc;
using ProyectoWebApiPuntoNet.Interface;
using ProyectoWebApiPuntoNet.Models;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace ProyectoWebApiPuntoNet.Controllers
{


 [ApiController]
 [Route("api/[controller]")]
 public class PersonaController : ControllerBase
 {


  private readonly ILogger<PersonaController> _logger;

  private IPersonaService personaService;


  public PersonaController(ILogger<PersonaController> logger, IPersonaService service)
  {
   _logger = logger;
   personaService = service;
  }







  
  [HttpGet]
  //[HttpGet(Name = "GetWeatherForecast")]
  // IEnumerable<WeatherForecast>
  public List<PersonaEntity> getAllPersona()
  {

   List<PersonaEntity> personas = new List<PersonaEntity>
   {
    new PersonaEntity {
     Nombre = "Juan",

     Edad = 21
    },
    new PersonaEntity
    {
     Nombre = "Maria"
    },
   };

   DateTime fechaHoraRecepcionSolicitud = DateTime.Now;

   DateOnly fehaRecepcionSolicitud = DateOnly.FromDateTime(DateTime.Now.AddDays(0));


   System.Console.Write("fecha y hora: ");
   System.Console.WriteLine(fechaHoraRecepcionSolicitud);

   System.Console.Write("fecha: ");
   System.Console.WriteLine(fehaRecepcionSolicitud);



   return personas;
  }


  //----
  [HttpGet]
  (
		ILogger<PersonaController> logger,
		IPersonaService service
	)
	{
		_logger = logger;
		personaService = service;
	}
  public Persona getById(int id)
  {
   System.Console.WriteLine("persona con el id: " + id);

   //
   Persona persona = new Persona();
   persona.Nombre = "Maria";
   persona.Edad = 21;
   return persona;
   //


   //
   dynamic
   return new {
 Nombre = "Marta Julia",
 Edad = 21,
};
//

return new Persona
{
 Nombre = "Pedro",
 Edad = 34
};

}
//----





  [HttpPost]
  public void post()
  {
  }



  [HttpPut]
  public void put()
  {
  }





  [HttpDelete("{id}")]
  public void deleteById(int id)
  {

   string token = Request.Headers.Where(headerN =>
     headerN.Key == "Authorization"
   ).FirstOrDefault().ToString();

   System.Console.WriteLine("token: " + token);

   // IActionResult


  }







 } // controller 



} // namespace 
*/

/*
Binding source parameter inference
Attribute	Binding source

[FromBody]	Request body
[FromForm]	Form data in the request body
[FromHeader]	Request header
[FromQuery]	Request query string parameter
[FromRoute]	Route data from the current request
[FromServices]	The request service injected as an action parameter
[AsParameters]	Method parameters

*/

