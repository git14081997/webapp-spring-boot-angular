
// https://www.youtube.com/watch?v=OuiExAqVapk
// 1.33.00

using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LibraryPersonal.Entity
{


 public class Usuario
 {

  [Key]
  [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
  public int Id { get; set; }


  [Required( ErrorMessage = "Nombre requerido")]
  //[RegularExpression("^[a-zA-Z0-9]")]
  [MaxLength(255)]
  public string Nombre { get; set; }


  public string NombreDos { get; set; }


  public string Apellido { get; set; }


  public string ApellidoDos { get; set; }


  public string? NombreCompleto { get; set; }


  public string? Comentarios { get; set; }


  public decimal? PendienteDePago { get; set; }


  public Usuario()
  {
  }


 } // class 

} // namespace 
