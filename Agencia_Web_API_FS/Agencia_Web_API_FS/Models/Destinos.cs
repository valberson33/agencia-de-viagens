using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace Agencia_Web_API_FS.Models
{

    [Table ("Destino")]
    public class Destinos
    {
        [Key]
        public int ID { get; set; }
        [Required(ErrorMessage ="informe a descrição do Estado")]
        [StringLength(50)]
        public String Estado{ get; set; }
      [Required (ErrorMessage = "informe a descrição do Cidade")]

        public String Cidade { get; set; }
        [Required(ErrorMessage = "informe a data do destino")]
        public DateTime DataDoDestino { get; set; }

    }
}
