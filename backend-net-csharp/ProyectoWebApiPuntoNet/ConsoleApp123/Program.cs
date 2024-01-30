
using LibraryPersonal.Entity;

namespace ConsoleApp123
{

 public class Program
 {

  static void Main(string[] args)
  {


   Console.WriteLine("Hello, World!");

   IEnumerable<Usuario> usuarios = new List<Usuario>
   {
    new Usuario{ Id = 1, Nombre = "Juan", Apellido = "Perez" },
    new Usuario{ Id = 2, Nombre = "Jose", Apellido = "Lopez" },
    new Usuario{ Id = 3, Nombre = "Jaime", Apellido = "Gomez" },
   };

   foreach ( Usuario usuarioN in usuarios )
   {
    Console.WriteLine(usuarioN.Id + " " + usuarioN.Nombre + " " + usuarioN.Apellido );
   }

  } // main 

 } // class 
} // namespace 
