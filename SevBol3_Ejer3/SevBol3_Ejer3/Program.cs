using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace SevBol3_Ejer3
{
    class Program
    {
        static void Main(string[] args)
        {
            int puerto = 10823;
            bool apagar = false;
            IPEndPoint ie = new IPEndPoint(IPAddress.Any, puerto);

            using (Socket s = new Socket(AddressFamily.InterNetwork,SocketType.Stream,ProtocolType.Tcp))
            {

            }
        }
    }
}
