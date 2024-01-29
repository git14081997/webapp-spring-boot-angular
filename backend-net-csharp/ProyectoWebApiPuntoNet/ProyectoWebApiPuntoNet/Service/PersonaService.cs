
using Microsoft.EntityFrameworkCore;
using ProyectoWebApiPuntoNet.Interface;
using LibraryPersonal.Entity;

namespace ProyectoWebApiPuntoNet.Service
{


 public class PersonaService : IService<Persona>
 {


  private DbContext _context;

  public PersonaService( DbContext dbContext ) 
  {
   _context = dbContext;
  }


  List<Persona> IService<Persona>.getAll()
  {
   throw new NotImplementedException();
  }




  Persona IService<Persona>.getById(int id)
  {
   throw new NotImplementedException();
  }



  int IService<Persona>.post(Persona persona)
  {
   throw new NotImplementedException();
  }



  void IService<Persona>.put(Persona persona)
  {
   throw new NotImplementedException();
  }


 } // class

} // namespace
