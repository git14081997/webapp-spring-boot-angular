
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LibraryPersonal.Dto
{

    public class PersonaDTO
    {
        public int Id { get; set; }
        public string? Nombre { get; set; }
        public int? Edad { get; set; }
        public decimal? Altura { get; set; }
        public DateTime? FechaNacimiento { get; set; }


        // referencia circular
        //public virtual ICollection<Maquina> Maquinas { get; set; }




        public PersonaDTO()
        {
            // 1 Persona Tiene Muchas Maquinas
        }





    } // class PersonaDTO


} // namespace 
