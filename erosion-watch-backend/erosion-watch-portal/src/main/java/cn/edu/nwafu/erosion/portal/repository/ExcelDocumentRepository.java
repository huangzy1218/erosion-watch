package cn.edu.nwafu.erosion.portal.repository;

import cn.edu.nwafu.erosion.portal.domain.ExcelDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Huang Z.Y.
 */
public interface ExcelDocumentRepository extends MongoRepository<ExcelDocument, String> {
}
