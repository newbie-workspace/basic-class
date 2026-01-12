import { useParams } from "react-router";
export default function Team() {

    const params = useParams();

    return (
        <>
            <h3>
                Team Overview
                <hr />
                Team ID: {params.teamId} |
                Group ID: {params.groupId}
            </h3>
        </>
    );

}