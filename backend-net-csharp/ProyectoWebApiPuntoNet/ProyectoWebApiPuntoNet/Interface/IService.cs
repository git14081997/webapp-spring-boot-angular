
using LibraryPersonal.Entity;

namespace ProyectoWebApiPuntoNet.Interface
{

 public interface IService<T>
 {

  public List<T> getAll();
  public T getById(int id);
  public int post(T persona);
  public void put(T persona);

 } // interface 


} // namespace 
