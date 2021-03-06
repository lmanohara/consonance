#!/bin/bash

# run coordinator and containerProvisioner in background
nohup java -cp consonance-arch-*.jar io.consonance.arch.coordinator.Coordinator --config config --endless > coordinator_nohup.out 2>&1&
nohup java -cp consonance-arch-*.jar io.consonance.arch.containerProvisioner.ContainerProvisionerThreads --config config --endless > container_provisioner_nohup.out 2>&1&

# run consonance webservice in foreground
java -jar consonance-webservice-*.jar server web.yml
