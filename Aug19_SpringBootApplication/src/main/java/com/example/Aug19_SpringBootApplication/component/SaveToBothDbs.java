package com.example.Aug19_SpringBootApplication.component;

import com.example.Aug19_SpringBootApplication.entities.*;
import com.example.Aug19_SpringBootApplication.mysqlRepo.*;
import com.example.Aug19_SpringBootApplication.oracleRepo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class SaveToBothDbs {
    private final MysqlDocumentRepo mysqlDocRepo;
    private final OracleDocumentRepo oracleDocRepo;
    private final MysqlAadhaarRepository mysqlAadhaarRepo;
    private final OracleAadhaarRepository oracleAadhaarRepo;

    @Transactional("mysqlTx")
    public Long saveMysql(DocumentRecord doc) { return mysqlDocRepo.save(doc).getId(); }

    @Transactional("oracleTx")
    public Long saveOracle(DocumentRecord doc) { return oracleDocRepo.save(doc).getId(); }

    @Transactional("mysqlTx")
    public Long saveMysql(AadhaarRecord ar) { return mysqlAadhaarRepo.save(ar).getId(); }

    @Transactional("oracleTx")
    public Long saveOracle(AadhaarRecord ar) { return oracleAadhaarRepo.save(ar).getId(); }

    public static DocumentRecord newDoc(String file, String type, String status, String sum) {
        return DocumentRecord.builder()
                .fileName(file).contentType(type).status(status).summary(sum)
                .createdAt(Instant.now()).build();
    }
}

