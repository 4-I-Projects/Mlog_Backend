generate-user-service:
	java -jar tools/openapi-generator-cli.jar generate -g spring -i openapi.yaml -o services/user/generated --additional-properties="useSpringBoot3=true,delegatePattern=true,javaVersion=17,apiPackage=com.mlog.user.api,modelPackage=com.mlog.user.model,configPackage=com.mlog.user.config,basePackage=com.mlog.user,useTags=true"

