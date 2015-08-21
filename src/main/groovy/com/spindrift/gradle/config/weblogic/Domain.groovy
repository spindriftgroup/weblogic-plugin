/**
 * Copyright (C) 2015 Spindrift B.V. All Rights Reserved
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spindrift.gradle.config.weblogic

import groovy.lang.Closure

import org.gradle.util.ConfigureUtil

import java.util.List

class Domain {

  String name
  String adminPassword='webl0gic'
  boolean isDefault=false
  String serverStartMode='dev'
  boolean overwriteDomain=true
  boolean forceShutdown=true
  String scriptPermissions='750'
  
  /** Defines the servers for the domain **/
  List<Server> servers = []
  def servers(Closure closure) {
    ConfigureUtil.configure(closure, servers)
  }
  
  def server(Closure closure) {
    closure.resolveStrategy = Closure.DELEGATE_FIRST
    Server server = new Server()
    closure.delegate = server
    servers << server
    closure()
  }
  
  /** Defines the datasources for the domain **/
  List<DataSource> dataSources = []
  def dataSources(Closure closure) {
    ConfigureUtil.configure(closure, dataSources)
  }
  
  def dataSource(Closure closure) {
    closure.resolveStrategy = Closure.DELEGATE_FIRST
    DataSource dataSource = new DataSource()
    closure.delegate = dataSource
    dataSources << dataSource
    closure()
  }
  
  AppDeployment appDeployment = []
  def appDeployment(Closure closure) {
    ConfigureUtil.configure(closure, appDeployment)
  }

  JTADescriptor jta = []
  def jta(Closure closure) {
    ConfigureUtil.configure(closure, jta)
  }
  
  @Override
  String toString() {
    """Domain ${name}: isDefault=${isDefault},serverStartMode=${serverStartMode},overwriteDomain=${overwriteDomain},forceShutdown=${forceShutdown},scriptPermissions=${scriptPermissions}
         Servers: ${servers}
         ${appDeployment}
         ${jta}
         DataSources: ${dataSources}
"""
  }
}
