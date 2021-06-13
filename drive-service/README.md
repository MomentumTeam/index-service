# drive-service

when you want to change the proto file (run from "main" folder)
run with protoc-gen-grpc-java v1.15.0

change proto for all files:

```
protoc --plugin=/usr/local/bin/protoc-gen-grpc-java --grpc-java_out=java --proto_path=resources/DriveProtos resources/DriveProtos/*
```

change proto for specific proto:

```
protoc --plugin=/usr/local/bin/protoc-gen-grpc-java --grpc-java_out=java --proto_path=resources/DriveProtos resources/DriveProtos/<proto-file.proto>
```

generate outer class:

```
protoc --proto_path=resources/DriveProtos resources/DriveProtos/* --java_out=java
```
