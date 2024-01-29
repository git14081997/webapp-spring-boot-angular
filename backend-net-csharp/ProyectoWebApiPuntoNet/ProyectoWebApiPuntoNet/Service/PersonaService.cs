
using Microsoft.EntityFrameworkCore;
using ProyectoWebApiPuntoNet.Interface;
using LibraryPersonal.Entity;

namespace ProyectoWebApiPuntoNet.Service
{


 public class PersonaService : IPersonaService
 {


  private DbContext _context;

  public PersonaService( DbContext dbContext ) 
  {
   _context = dbContext;
  }


  List<Persona> IPersonaService.getAll()
  {

   throw new NotImplementedException();
  }


  Persona IPersonaService.getById(int id)
  {
   throw new NotImplementedException();
  }


  int IPersonaService.post(Persona persona)
  {
   return 0;
  }


  void IPersonaService.put(Persona persona)
  {
  }


 } // class

} // namespace
