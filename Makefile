generate-user-service:
	java -jar tools/openapi-generator-cli.jar generate -g spring -i openapi.yaml -o services/user/generated --additional-properties="useSpringBoot3=true,delegatePattern=true,javaVersion=17,apiPackage=com.mlog.user.api,modelPackage=com.mlog.user.model,configPackage=com.mlog.user.config,basePackage=com.mlog.user,useTags=true"

generate:
	java -jar tools/openapi-generator-cli.jar generate -g spring -i openapi.yaml -o services/engagement/generated --config tools/config.json --additional-properties="useSpringBoot3=true,delegatePattern=true,javaVersion=17,apiPackage=com.mlog.engagement.api,modelPackage=com.mlog.engagement.model,configPackage=com.mlog.engagement.config,basePackage=com.mlog.engagement,useTags=true" 

