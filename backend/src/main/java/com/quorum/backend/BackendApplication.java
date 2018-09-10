package com.quorum.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.methods.response.*;
import org.web3j.quorum.*;
import org.web3j.quorum.tx.ClientTransactionManager;
import com.quorum.backend.contracts.SimpleStorage;
import org.web3j.tx.Contract;

import java.math.BigInteger;
import java.util.Arrays;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) throws Exception{

		SpringApplication.run(BackendApplication.class, args);
		String deployeraccount = "0xed9d02e382b34818e88b88a309c7fe71e65f419d";
		String privfor = "QfeDAys9MPDs2XHExtc84jKGHxZg/aj52DTh0vtA3Xc=";


			Quorum quorum = Quorum.build(new HttpService("http://localhost:22000"));

			ClientTransactionManager transactionManager = new ClientTransactionManager(
					quorum, deployeraccount, Arrays.asList(privfor));

			BigInteger initVal = BigInteger.valueOf(1);

			System.out.println(">> Before deploy");

			SimpleStorage storage = SimpleStorage.deploy(quorum,
					transactionManager,
					GAS_PRICE,
					Contract.GAS_LIMIT,
					initVal).sendAsync().get();
			System.out.println(">> deploy");



			System.out.println(">> after wait");

			System.out.println(storage.get().sendAsync().get());



	}
}
