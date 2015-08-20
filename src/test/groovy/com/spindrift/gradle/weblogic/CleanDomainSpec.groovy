import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import static org.gradle.testkit.runner.TaskOutcome.*

class CleanDomainSpec extends spock.lang.Specification {
  @Rule public final TemporaryFolder testProjectDir = new TemporaryFolder();
  def File buildFile
  
  def setup() throws IOException {
    buildFile = testProjectDir.newFile("build.gradle")
  }
  
  def "cleanDomain prints clean domain message"() {
    given:
    buildFile << """
      buildscript {
        repositories {
          mavenLocal()
        }
        dependencies {
          classpath 'com.spindrift.gradle-weblogic-plugin:weblogic-plugin:0.1.0-SNAPSHOT'
        }
      }

      apply plugin: 'weblogic-plugin'
    """

    when:
    def result = GradleRunner.create()
        .withProjectDir(testProjectDir.root)
        .withArguments('cleanDomain')
        .build()

    then:
    result.standardOutput.contains('Cleaning domain ...')
    result.task(":cleanDomain").outcome == SUCCESS
}

}
