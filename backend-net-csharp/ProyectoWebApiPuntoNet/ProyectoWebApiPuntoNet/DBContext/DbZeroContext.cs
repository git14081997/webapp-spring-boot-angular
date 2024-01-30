
using Microsoft.EntityFrameworkCore;
using LibraryPersonal.Entity;

namespace ProyectoWebApiPuntoNet.DBContext
{

 public class DbZeroContext : DbContext
 {

  public DbSet<Persona> TPersona { get; set; }
  public DbSet<Maquina> TMaquina { get; set; }
  public DbSet<Usuario> TUsuario { get; set; }


  public DbZeroContext(DbContextOptions<DbZeroContext> opciones) : base(opciones)
  {

  } // constructor


  protected override void OnModelCreating(ModelBuilder modelBuilder)
  {

   // Nombre en singular de cada tabla
   modelBuilder.Entity<Persona>().ToTable("Persona");
   modelBuilder.Entity<Maquina>().ToTable("Maquina");
   modelBuilder.Entity<Usuario>().ToTable("Usuario");

   base.OnModelCreating(modelBuilder);
  }





 } // class 
} // namespace 
