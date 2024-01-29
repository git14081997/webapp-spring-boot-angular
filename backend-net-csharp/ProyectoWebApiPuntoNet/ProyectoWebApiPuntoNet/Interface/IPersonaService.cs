
using LibraryPersonal.Entity;

namespace ProyectoWebApiPuntoNet.Interface
{

 public interface IPersonaService
 {

  public List<Persona> getAll();
  public Persona getById(int id);
  public int post(Persona persona);
  public void put(Persona persona);

 } // interface 


} // namespace 
