package RabbitModels;

import Models.FileMetadata;
import Models.Permission;

import java.util.Optional;

public class ElasticRequest {
    public static Optional<Permission []> permissions;
    public static Optional<FileMetadata []> fileMetadata;
}
