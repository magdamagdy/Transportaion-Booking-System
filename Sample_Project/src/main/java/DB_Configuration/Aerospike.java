package DB_Configuration;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;

public class Aerospike {

    public AerospikeClient client = new AerospikeClient("127.0.0.1", 3000);
    //java object mapping
    public AeroMapper mapper = new AeroMapper.Builder(client).build();
}
