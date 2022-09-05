
def newGit(repo)
{
  git "${repo}"
}
def newMaven()
{
  sh 'mvn package'
}
def newDeploy(ip,appname)
{
  deploy adapters: [tomcat9(credentialsId: '898c13c4-28fd-4283-82d8-c07f78f8a5e8', path: '', url: "${ip}")], contextPath: "${appname}", war: '**/*.war'
}

def newTest(jobname)
{
  echo "${jobname}"
  sh "java -jar /home/ubuntu/.jenkins/workspace/${jobname}/testing.jar"
}
