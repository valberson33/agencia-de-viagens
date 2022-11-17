using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Agencia_Web_API_FS.Models
{
    public class DestinoDbContext : DbContext
    {
        public DestinoDbContext(DbContextOptions<DestinoDbContext> options)
           : base(options)
        { }

        public DbSet<Destinos> destino { get; set; }
    }
}
