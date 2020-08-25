class Courses:

    def check_pre_req(self, courses, prerequisites):
        print("Courses: {} Pre-Req: {}".format(courses, prerequisites))
        graph = {}
        for prereq in prerequisites:
            if prereq[0] in graph:
                graph[prereq[0]].append(prereq[1])
            else:
                graph[prereq[0]] = [prereq[1]]
        print("> {} {} {}".format(courses, prerequisites, graph))
        for course in range(courses):
            if self._hasCycle(graph, course, set(), {}):
                return False

        return True

    def _hasCycle(self, graph, course, seen, cache):
        print("graph {} courses {} seen {} cache {}".format(graph, course, seen, cache))
        if course in cache:
            return cache[course]

        if course in seen:
            return True
        if course not in graph:
            return False

        seen.add(course)
        ret = False
        for neighbors in graph[course]:
            if self._hasCycle(graph, neighbors, seen, cache):
                ret = True
                break
        seen.remove(course)

        cache[course] = ret
        return ret


print(Courses().check_pre_req(2, [[1, 0]]))
# True
print(Courses().check_pre_req(2, [[1, 0], [0, 1]]))
# False
