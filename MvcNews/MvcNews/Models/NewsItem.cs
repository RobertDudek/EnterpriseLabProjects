using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace MvcNews.Models
{
    public class NewsItem
    {
        public int Id
        { get; set; }
        [DataType(DataType.DateTime)]
        public DateTime TimeStamp
        { get; set; }
        [Required(ErrorMessage = "The message is required"), StringLength(140, MinimumLength = 5, ErrorMessage = "Message must be between 5 and 140 characters.")]
        public string Text
        { get; set; }
        [Timestamp]
        public byte[] RowVersion
        { get; set; }
    }
}
