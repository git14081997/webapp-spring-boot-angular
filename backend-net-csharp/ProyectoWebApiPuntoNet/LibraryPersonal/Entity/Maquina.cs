
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LibraryPersonal.Entity
{


 public class Maquina
 {

  [Key]
  [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
  public int Id { get; set; }

  public string Descripcion { get; set; }

  public int? funciones { get; set; }



  // fk -- begin
  public int PersonaId { get; set; }

  [ForeignKey("PersonaId")]
  public virtual Persona Persona { get; set; }
  // fk -- end


  public Maquina()
  {
  }




 } // class Persona


} // namespace 
