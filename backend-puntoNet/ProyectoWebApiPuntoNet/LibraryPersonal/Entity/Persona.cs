
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LibraryPersonal.Entity
{


 public class Persona
 {

  [Key]
  [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
  public int Id { get; set; }


  [Required( ErrorMessage = "Nombre requerido")]
  //[RegularExpression("^[a-zA-Z0-9]")]
  public string Nombre { get; set; }

  public int? Edad { get; set; }
  public decimal? Altura { get; set; }
  public DateTime? FechaNacimiento { get; set; }


  // referencia circular
  public virtual ICollection<Maquina> Maquinas { get; set; }




  public Persona()
  {
   // 1 Persona Tiene Muchas Maquinas
  }





 } // class Persona


} // namespace 
