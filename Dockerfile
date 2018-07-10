FROM payara/micro
COPY ./target/micro.war ${DEPLOY_DIR}
