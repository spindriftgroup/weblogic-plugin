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

import groovy.lang.Closure;

class DataSource {
  
  String name
  String user
  String target
  
  JDBCDriverParams jdbcDriverParams
  def jdbcDriverParams(Closure closure) {
    closure.resolveStrategy = Closure.DELEGATE_FIRST
    JDBCDriverParams closureJDBCDriverParams = new JDBCDriverParams()
    closure.delegate = closureJDBCDriverParams
    jdbcDriverParams = closureJDBCDriverParams
    closure()
  }

  JDBCConnectionPoolParams jdbcConnectionPoolParams
  def jdbcConnectionPoolParams(Closure closure) {
    closure.resolveStrategy = Closure.DELEGATE_FIRST
    JDBCConnectionPoolParams closureJDBCConnectionPoolParams = new JDBCConnectionPoolParams()
    closure.delegate = closureJDBCConnectionPoolParams
    jdbcConnectionPoolParams = closureJDBCConnectionPoolParams
    closure()
  }
  
  JDBCDataSourceParams jdbcDataSourceParams
  def jdbcDataSourceParams(Closure closure) {
    closure.resolveStrategy = Closure.DELEGATE_FIRST
    JDBCDataSourceParams closureJDBCDataSourceParams = new JDBCDataSourceParams()
    closure.delegate = closureJDBCDataSourceParams
    jdbcDataSourceParams = closureJDBCDataSourceParams
    closure()
  }
  
  @Override
  String toString() {
    """DataSource ${name}=[user=${user},target=${target}
         ${jdbcDriverParams}
         ${jdbcConnectionPoolParams}
         ${jdbcDataSourceParams}
       ]
"""

  }

}
