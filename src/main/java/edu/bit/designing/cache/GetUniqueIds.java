package edu.bit.designing.cache;

/**
 * Given a function which returns N unique ids required for database records
 *
 * List<String> getUniqueIds(int N) {
 * }
 *
 * This function is already implemented and can't be modified. The problem is that this function is slow.
 * Write a wrapper over this function which will not take any argument and return a single id. And also this wrapper should be able to return the result faster.
 *
 *
 *    List<String> uniqueIds = getUniqueIds(10);
 *
 *
 * String getUniqueId() {
 *
 * }
 * s
 *
 * class CachingIds {
 *   int N; // load N ids into the cache
 *   List<String> ids;
 *   int threshold;
 *
 *  void loadCache(int N) {
 *      ids = getUniqueIds(N);
 *  }
 *
 *  String getUniqueId() {
 *      return ids.remove(ids.size()); // handle exceptions if not present
 *  }
 *
 *  void reloadCache() {
 *      if(ids.size() <= threshold) loadCache(N);
 *  }
 *
 * }
 */
public class GetUniqueIds {
}
