import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.slbrazil.github_common_model.GithubRepo

interface GitHubRepository {
 fun getRepos(search: String) : LiveData<List<GithubRepo>>
}