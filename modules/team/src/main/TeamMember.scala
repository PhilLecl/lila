package lila.team

import org.joda.time.DateTime

import lila.common.LightUser
import lila.user.User

private[team] case class TeamMember(
    _id: String,
    team: TeamId,
    user: UserId,
    date: DateTime
):
  inline def id = _id

  def is(userId: UserId): Boolean = user == userId
  def is(user: User): Boolean     = is(user.id)

object TeamMember:

  case class UserAndDate(user: LightUser, date: DateTime)

  private[team] def makeId(team: TeamId, user: UserId) = s"$user@$team"

  private[team] def make(team: TeamId, user: UserId): TeamMember = new TeamMember(
    _id = makeId(team, user),
    user = user,
    team = team,
    date = DateTime.now
  )
